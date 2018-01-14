'use strict';

// Authentication service for user variables
angular.module('login')
    .factory('HomeFactory', function ($http){
        return {
            getReport : function (reportData) {
            	var fromDate = reportData.fromDate + "T" + reportData.fromTime
            	return $http.get('report/getReports/'+reportData.fromDateTime+"/"+reportData.toDateTime).then(function (response){
    	    		return response;
    	    	});
            }
        }
    });