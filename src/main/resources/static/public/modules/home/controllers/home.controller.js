'use strict';

angular.module('home').controller('HomeController', [ '$scope','$state', 'HomeFactory','$location',
    function ($scope, $state, HomeFactory,$location) {
        console.log("Home controller");
        $scope.home = {};
        $scope.showInitialForm = true;
        
        
        $scope.init = function () {
        	console.log($scope.report);
        	if ($scope.report)
        		$scope.showInitialForm = false;
        	else 
        		$scope.showInitialForm = true;
        }   
        
        $scope.getFieldErrorClass = function (fieldName) {
        	if ($scope.submitted && !fieldName) {
        		return 'error-class';
        	}
        }
        
        $scope.init();
        $scope.getReport = function () {
        	$scope.submitted = true;
        	if ($scope.homeForm.$valid) {
        		HomeFactory.getReport($scope.home).then(function (response) {
                    console.log("response:"+response);
                    $scope.report = response.data;
                    $scope.showInitialForm = false;
                }, function (errResponse) {
                    console.log(errResponse);
                    $scope.error = true;
                    $scope.errMsg = errResponse.data.message;
                });
        	}
        	
        }
    }
]);