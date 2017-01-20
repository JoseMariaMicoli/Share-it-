var app = angular.module('myApp', ['ngResource']);

app.controller('UserController', ['$scope', '$resource',function($scope,$resource) {
    
    function fetchAllUsers(){
        $scope.users = $resource('http://localhost:8080/user'
        ).query(function(data){return data;});
    };
    fetchAllUsers();
    
    $scope.refresh = function(){
    	fetchAllUsers();
    };
    
    $scope.create = function(){
    	User = $resource(
    		    "http://localhost:8080/create",
    		    {},
    		    {save: {method:'PUT',isArray:false}}
    	);
    	
    	var user = {};
		
		user.id = $scope.userForm.id;
		user.name = $scope.userForm.name;
		user.phone = $scope.userForm.mobile;
		user.password = $scope.userForm.password;
		user.confirmPassword = "";
		user.email = $scope.userForm.email;
		user.birthday = $scope.userForm.birthday;
		
		$scope.Message = User.save(user);
				
		$scope.userForm.id = "";
		$scope.userForm.name="";
		$scope.userForm.mobile="";
		$scope.userForm.password="";
		$scope.userForm.email="";
		$scope.userForm.birthday="";
    };
    
    $scope.deleteRec = function(){
    	User = $resource(
    		    "http://localhost:8080/delete/:id",
    		    {},
    		    {save: {method:'DELETE', params: {id: '@id'}}}
    	);
    	
			
		User.delete({id: $scope.userForm.id}).then(function successCallback(response) {
			$scope.Message = response;
		}, function errorCallback(response) {
		    
		});
				
		$scope.userForm.id = "";
		$scope.userForm.name="";
		$scope.userForm.mobile="";
		$scope.userForm.password="";
		$scope.userForm.email="";
		$scope.userForm.birthday="";
    };
    
    
    $scope.update = function(){
    		
    	User = $resource(
    		    "http://localhost:8080/update/:id",
    		    {},
    		    {save: {method:'PUT', params: {id: '@id'}}}
    	);
    	
		var user = {};
		
		user.id = $scope.userForm.id;
		user.name = $scope.userForm.name;
		user.phone = $scope.userForm.mobile;
		user.password = $scope.userForm.password;
		user.confirmPassword = "";
		user.email = $scope.userForm.email;
		user.birthday = $scope.userForm.birthday;
		
		$scope.Message = User.save({id: $scope.userForm.id}, user);
				
		$scope.userForm.id = "";
		$scope.userForm.name="";
		$scope.userForm.mobile="";
		$scope.userForm.password="";
		$scope.userForm.email="";
		$scope.userForm.birthday="";
    };
    
}]);
