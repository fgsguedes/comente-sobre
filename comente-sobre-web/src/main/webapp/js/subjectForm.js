$(document).ready(function () {

    $('#subjectForm').validate({
        rules: {
            'subject.name': {
                required: true
            }
        },
        messages: {
            'subject.name': {
                required: 'Digite sobre o que deseja comentar'
            }
        },
        errorPlacement: function(error, element) {
            error.insertBefore(element);
        }
    })

});
