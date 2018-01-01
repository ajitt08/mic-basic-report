'use strict';

// Authentication service for user variables
angular.module('login')
    .factory('LoginFactory', function ($http){
        return {
            login : function (login) {
                return $http({
                    url: 'login',
                    method: 'POST',
                    data: 'username='+encodeURIComponent(login.username)+'&password='+encodeURIComponent(login.password),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (response) {
                	console.log("success:"+response);
                    return response;
                }).error(function (status) {
                	console.log("failure:"+response);
                	return status;
                });
            }
        }
    });