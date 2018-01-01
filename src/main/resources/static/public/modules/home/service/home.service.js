'use strict';

// Authentication service for user variables
angular.module('login')
    .factory('HomeFactory', function ($http){
        return {
            getReport : function (reportData) {
            	return $http.get('report/getReports/'+reportData.fromDate+"/"+reportData.toDate).then(function (response){
    	    		return response;
    	    	});
            }
        }
    });