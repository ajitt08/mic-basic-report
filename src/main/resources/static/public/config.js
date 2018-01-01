'use strict';

// Init the application configuration module for AngularJS application
var ApplicationConfiguration = (function () {
    // Init module configuration options
    var applicationModuleName = 'wolfattireApp';
    var applicationModuleVendorDependencies = [ 'ui.router','720kb.datepicker'];

    // Add a new vertical module
    var registerModule = function (moduleName) {
        // Create angular module
        angular.module(moduleName, []);

        // Add the module to the AngularJS configuration file
        angular.module(applicationModuleName).requires.push(moduleName);
        //baseURL needs to be changes
        angular.module(moduleName,[]).constant("baseURL","/jx-studentportal-ui-1.0-SNAPSHOT/api/");
        //angular.module(moduleName,[]).constant("PAGE_SIZE",10);
    };

    return {
        applicationModuleName: applicationModuleName,
        applicationModuleVendorDependencies: applicationModuleVendorDependencies,
        registerModule: registerModule
    };
})();