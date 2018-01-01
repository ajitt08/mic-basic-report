'use strict';

angular.module('login').controller('LoginController', [ '$scope','$state', 'LoginFactory','$location',
    function ($scope, $state, LoginFactory,$location) {
        $scope.message = "";
        $scope.login = function () {
        	console.log("submit controller");
            LoginFactory.login($scope.login).then(function (response) {
            	console.log("success")
                $location.path("/home")
            }, function (errResponse) {
                $scope.message = errResponse.data.message;
            });
        };
    }
]);