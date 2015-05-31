app.directive('bgrimage', function() {
    return {
        restrict: 'AE',
        scope: true,
        templateUrl: 'js/bgrimage/bgrimage.html',
        link: function(scope, elem, attr) {
            scope.buttonToggle = function() {
                if (scope.subject.sendToEdit==false)
                    scope.subject.sendToEdit=true;
                else
                    scope.subject.sendToEdit=false;
                
            }
        }
    };
});