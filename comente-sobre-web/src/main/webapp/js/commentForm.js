$(document).ready(function () {

    $('#commentForm').validate({
        rules: {
            'comment.owner.email': {
                required: true,
                email: true
            },
            'comment.text': {
                required: true
            }
        },
        messages: {
            'comment.owner.email': {
                required: 'Informe seu e-mail',
                email: 'Digite um e-mail válido'
            },
            'comment.text': {
                required: 'Informe seu comentário'
            }
        },
        errorClass: 'error',
        errorElement: 'span',
        errorPlacement: function(error, element) {
            var elementId = $(element).attr('id');
            $('label.' + elementId).append(error);
        }
    });

});
