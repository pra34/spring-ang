(function(){

    'use strict';

    // defining the controller
    angular.module('myApp')
    .controller('UserController', UserController);

    // injecting into controller
    UserController.$inject = ['$scope', 'UserService', '$state', '$stateParams', '$log'];

    // controller function
    function UserController($scope, UserService, $state, $stateParams, $log) {

        var vm = this;

        // properties
        vm.user = {};
        vm.users = [];

        // methods
        vm.reset = reset;

        // CRUD methods
        vm.fetchAllUsers = fetchAllUsers;
        vm.createUser = createUser;
        vm.deleteUser = deleteUser;

        // initializing method
        activate();
        function activate() {
            fetchAllUsers();
        
        } // end of activate function

        // reset form
        function reset() {
            vm.user = {};

        } // end of reset function

        // fetch all users
        function fetchAllUsers() {
            // clean the users object
            vm.users = [];
            UserService.fetchAllUsers()
                .then(
                    function(successResponse) {
                        vm.users = successResponse;
                    },
                    function(errorResponse){
                        $log.error(errorResponse);
                        $log.info('Error while fetching Users');
                    }
                );
        } // end of fetchAllUser function

        // create user
        function createUser(formObject) {

            UserService.createUser(vm.user)
                .then(
                    function(successResponse){
                        $state.go('index.list'); // redirect to index.list state
                    },
                    function(errorResponse){
                        $log.error(errorResponse);
                        $log.info('Error while creating User');
                    }
                );

        } // end of createUser function

        // delete user
        function deleteUser(id) {

             UserService.deleteUser(id)
                .then(
                    function(successResponse){
                        $state.go('index.list'); // redirect to index.list state
                    },
                    function(errorResponse){
                        $log.error(errorResponse);
                        $log.info('Error while deleting User');
                    }
                );

        } // end of deleteUser funciton

    } // end of UserController

})();

