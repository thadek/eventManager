//Boton subir hacia inicio de pagina

jQuery(document).ready(function() {
  
    var btn = $('#back-to-top');
  
    $(window).scroll(function() {
      if ($(window).scrollTop() > 300) {
        btn.addClass('show');
      } else {
        btn.removeClass('show');
      }
    });
  
    btn.on('click', function(e) {
      e.preventDefault();
      $('html, body').animate({scrollTop:0}, '150');
    });
  
  });