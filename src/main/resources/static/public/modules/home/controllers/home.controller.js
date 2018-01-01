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
        
        $scope.validateToDate = function (fromDate, toDate) {
        	var curDate = new Date();
        	$scope.errMsg = "";
        	$scope.toDateError = false;
        	if (new Date(toDate) < new Date(fromDate)){
        		$scope.toDateError = true;
        		$scope.errMsg = "To Date can't be less than From Date";
        	}
        	if (new Date(toDate) > curDate){
        		$scope.toDateError = true;
        		$scope.errMsg = "To Date can't be greater than Today's Date";
        	}
        		
        }
        
        $scope.validateFromDate = function (fromDate) {
        	var curDate = new Date();
        	$scope.errMsg = "";
        	$scope.fromDateError = false;
        	
        	if (new Date(fromDate) > curDate){
        		$scope.fromDateError = true;
        		$scope.errMsg = "From Date can't be greater than Today's Date";
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