'use strict'

angular.module('login').config(['$stateProvider', '$urlRouterProvider',
                                function ($stateProvider, $urlRouterProvider) {
	
	 // Redirect to Signin view when route not found
    $urlRouterProvider.otherwise('/login');

    // Users state routing
    $stateProvider.state('login', {
        url: '/login',
        controller: 'LoginController',
        templateUrl:'public/modules/login/views/login.view.html'
    });
}]);