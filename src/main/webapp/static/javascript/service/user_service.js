(function() {
    'use strict';

    // defining the service
    angular.module('myApp')
    .factory('UserService', UserService);

    // injecting into service
    UserService.$inject = ['$http', '$q'];

    // service function
    function UserService($http, $q) {

        // api url
        var REST_SERVICE_URI = 'http://localhost:8084/springRest/';

        // service object
        var factory = {
            fetchAllUsers: fetchAllUsers,
            createUser: createUser,
            updateUser:updateUser,
            deleteUser:deleteUser,
            getUser: getUser
        };

        return factory;
        
        // fetch user with id
        function getUser(id) {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+'user/'+id)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching user with id ' + id);
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;

        } // end of getUser function

        // fetch all users
        function fetchAllUsers() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+'users')
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;

        }// end of fetchAllUsers

        function createUser(user) {
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI+'user/add', user)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating User');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;

        }// end of createUser function

        // modify the user
        function updateUser(user, id) {
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI+'user/edit', user)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while updating User');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;

        } // end of updateUser function

        // remove the user
        function deleteUser(id) {
            var deferred = $q.defer();
            $http.delete(REST_SERVICE_URI+'/user/'+id)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while deleting User');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;

        } // end of deleteUser function


    } // end of UserService

})();

