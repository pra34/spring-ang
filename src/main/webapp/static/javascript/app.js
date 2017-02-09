'use strict';

var App = angular.module('myApp',['ui.router']);

App.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');
    
    $stateProvider
        
    // index
    .state('index', {
        url: '/',
        templateUrl: 'pages/partial/partial-index.html'
    })

    // nested list with UserController
    .state('index.list', {
        url: 'list',
        templateUrl: 'pages/partial/partial-index-list.html',
        controller: 'UserController as ctrl'
    })

    // nested add with UserController
    .state('index.add', {
        url: 'add',
        templateUrl: 'pages/partial/partial-index-add.html',
        controller: 'UserController as ctrl'
    })

    // nested edit with UserEditController 
    .state('index.edit', {
        url : 'edit/:user',
        templateUrl: 'pages/partial/partial-index-edit.html',
        controller: 'UserEditController as ctrl'
    });

});    