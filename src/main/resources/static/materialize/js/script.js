  // Função para esconder a mensagem após um período de tempo
  function hideFlashMessage() {
    var flashMessage = document.getElementById('flash-message');
    flashMessage.style.display = 'none';
  }

  // Define o tempo em milissegundos após o qual a mensagem deve desaparecer (exemplo: 3000ms = 3 segundos)
  var hideTimeout = 3000;

  // Configura um temporizador para chamar a função hideFlashMessage após o tempo especificado
  setTimeout(hideFlashMessage, hideTimeout);