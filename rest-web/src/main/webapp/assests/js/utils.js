$(document).ready(function () {
	$('#addPerson').click(function () {
		addPerson();
	});
	$('#deletePerson').click(function () {
		deletePerson();
	});
	$('#personAdd').click(function () {
		addRestPerson();
	});
	$('#personUpdate').click(function () {
		updatePerson();
	});
	$('#personDelete').click(function () {
		deletePerson();
	});
});

function addPerson() {
	$('#personForm').prop('action', 'add');
	$('#personButton').prop('value', 'Add person');
	$('#personForm').show();
}

function deletePerson() {
	$('#personForm').prop('action', 'delete');
	$('#personButton').prop('value', 'Delete person');
	$('#personForm').show();
}

function addRestPerson() {
    var name = $("#name").val();
    var surname = $("#surname").val();
    var age = $("#age").val();
    if (name && surname && age) {
        var person = {
            name: name,
            surname: surname,
            age: age
        };
        $.ajax({
            data:JSON.stringify(person),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            type:'post',
            url: restUrl
        }).done(function(data) {
            var el = '<div id="' + data.id + '">'+ data.name +'    '+data.surname+'    '+data.age+'</div>';
            $("#personTable").append(el);
        }).fail(function(data){
            if ( console && console.log ) {
                console.log( "Error data:", data);
            }
        });
    }
}