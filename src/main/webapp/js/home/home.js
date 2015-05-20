angular.module('home', []).controller('homeCtrl', function($scope, $http, $modal, $log, hotkeys) {

  $scope.jobnumber;
  $scope.subjects = [];

  $scope.currentPage = 1;
  $scope.itemsPerPage = 8;
  $scope.maxSize = 6;
  $scope.totalItems = $scope.subjects.length + $scope.itemsPerPage;   
  
  
  $scope.addSubjects = function (){
    for (i = 0; i < 25; i++) { 
      $scope.subjects.push({"name":"Fred was here","piecenumber":"ZZ10M100H003","seq":$scope.subjects.length+1,"image":"http://dummyimage.com/250x300/ffff00.png/000000&text=image "+($scope.subjects.length+1),"redobgr":0})
    }
    $scope.totalItems = $scope.subjects.length + $scope.itemsPerPage; 
  };

  $scope.saveSubjects = function (){
    $http.post('/subjects', $scope.subjects).
      success(function(data, status, headers, config) {
        // this callback will be called asynchronously
        // when the response is available
            $log.info("Saved subjects");
      }).
      error(function(data, status, headers, config) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
            $log.info("Error saving subjects");
    });
  }
  
  $scope.logSubjects = function () {
    $log.info(JSON.stringify($scope.subjects));  
  };
  

  $scope.refresh = function (){
    location.reload();
  };
   
  $scope.openJob = function () {
    var modalInstance = $modal.open({
      animation: true,
      templateUrl: 'js/newjob/newjob.html',
      controller: 'NewJobCtrl',
      resolve: {
        items: function () {
          return $scope.items;
        }
      }
    });

    modalInstance.result.then(function (jobnumber) {
      $log.info('Jobnumber is: ', jobnumber);
      $scope.jobnumber = jobnumber;
      $http.get('subjects/'+jobnumber).
        success(function(data) {
          $scope.subjects = data;
          $scope.totalItems = $scope.subjects.length + $scope.itemsPerPage;
        });

    }, function () {
      $log.info('Modal dismissed at: ' + new Date());
    });
  };
  
  hotkeys.bindTo($scope)
    .add({
      combo: 'left',
      description: 'Back one page',
      callback: function () {
        $scope.currentPage = $scope.currentPage-1;
        if ($scope.currentPage<=1)
          $scope.currentPage=1;
       }
    })
    // you can chain these methods for ease of use:
    .add ({
      combo: 'right',
      description: 'Forward one page',
      callback: function () {
        $scope.currentPage = $scope.currentPage+1;
        if($scope.currentPage>= $scope.totalItems/$scope.itemsPerPage)
          $scope.currentPage = $scope.currentPage-1;
        }
    });
 
  
});
