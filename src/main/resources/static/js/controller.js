app.controller('atmsController', function($scope, $http) {
    $scope.headingTitle = "Atms List";

    $http.get('http://localhost:8080/api/atm').
    then(function(response) {
        $scope.atms = response.data;
    });
});
