(function() {
    'use strict';

    // defining the controller
    angular.module('myApp')
    .controller('UserEditController', UserEditController);

    // injecting into controller
    UserEditController.$inject = ['$scope', 'UserService', '$state', '$stateParams', '$log'];

    // controller function
    function UserEditController($scope, UserService, $state, $stateParams, $log) {
        var vm = this;

        // properties
        vm.user = {};
        vm.original_user = {};
        vm.users = [];
        vm.user_id = $stateParams.user;

        // methods
        vm.reset = reset;

        // CRUD methods
        vm.getUser = getUser;
        vm.updateUser = updateUser;

        // initializing function
        activate();
        function activate() {
            getUser(vm.user_id); // fetch the user with id in URL

        }// end of activate function

        // reset the form
        function reset() {

            vm.user = angular.copy(vm.original_user); // copy the original user to user object

        }// end of reset function

        // fetch the user with id
        function getUser(id) {

            UserService.getUser(id)
            .then(
                function(successResponse) {
                    vm.original_user = successResponse;
                    vm.user = angular.copy(vm.original_user); // copy the original user to user object
                },
                function(errResponse){
                    $log.error(errResponse);
                    $log.info('Error while fetching User');
                }
            );

        }// end of getUser function

        // update user
        function updateUser(formObject) {

            UserService.updateUser(vm.user, vm.user.id)
                .then(
                function(successResponse){
                    $state.go('index.list'); // redirect to index.list state
                },
                function(errResponse){
                    $log.error(errResponse);
                    $log.info('Error while updating User');
                }
            );

        } // end of updateUser function


    } // end of UserEditController function

})();
