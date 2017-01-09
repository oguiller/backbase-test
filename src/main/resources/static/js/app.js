var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/atms',{
            templateUrl: '/views/list-atms.html',
            controller: 'atmsController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

