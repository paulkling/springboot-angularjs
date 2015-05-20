app.directive('bgrimage', function() {
    return {
        restrict: 'AE',
        scope: true,
        templateUrl: 'js/bgrimage/bgrimage.html',
        link: function(scope, elem, attr) {
            scope.buttonToggle = function() {
                if (scope.subject.redobgr==0)
                    scope.subject.redobgr=1;
                else
                    scope.subject.redobgr=0;
                
            }
        }
    };
});