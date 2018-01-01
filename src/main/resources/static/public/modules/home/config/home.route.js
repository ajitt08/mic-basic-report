'use strict';

// Setting up route
angular.module('home').config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        // home state routing
        $stateProvider.state('home', {
        	 url: '/home',
             controller: 'HomeController',
             templateUrl:'public/modules/home/views/home.view.html'
        }).state('home.logout', {
            url: '/logout',
            controller: 'LogoutController'
        });;
    }
])