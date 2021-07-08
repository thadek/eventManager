//Boton subir hacia inicio de pagina
fotitoPerfil();
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

  function fotitoPerfil(){
    let username = document.getElementById("usdatos").innerHTML;
    
    fetch(`http://localhost:8080/api/perfil/ver/foto/${username}`).then(r=>r.json()).then(d=>{document.getElementById("photoUser").src=d.foto});
  }