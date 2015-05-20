var app = angular
  .module('app', [ 'ngRoute', 'ui.bootstrap', 'home', 'cfp.hotkeys'])
	.config(
        function($routeProvider, $httpProvider, $locationProvider) {
			$routeProvider.when('/', {
				templateUrl : 'js/home/home.html',
				controller : 'homeCtrl'
			}).otherwise('/');

			$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            $locationProvider.html5Mode(true);
		});
		


app.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.ngEnter);
                });
                event.preventDefault();
            }
        });
    };
});


app.filter('offset', function() {
  return function(input, start) {
    start = parseInt(start, 10);
    return input.slice(start);
  };
});
