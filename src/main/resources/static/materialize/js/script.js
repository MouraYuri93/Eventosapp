  // Função para esconder a mensagem após um período de tempo
  function hideFlashMessage() {
    var flashMessage = document.getElementById('flash-message');
    flashMessage.style.display = 'none';
  }

  // Define o tempo em milissegundos após o qual a mensagem deve desaparecer (exemplo: 3000ms = 3 segundos)
  var hideTimeout = 3000;

  // Configura um temporizador para chamar a função hideFlashMessage após o tempo especificado
  setTimeout(hideFlashMessage, hideTimeout);

  // Função para formatar a data no formato dd/mm/aaaa
  function formatarData(data) {
    var partes = data.split('-');
    var dia = partes[2];
    var mes = partes[1];
    var ano = partes[0];
    return dia + '/' + mes + '/' + ano;
  }

  // Obter todas as células de data na tabela de eventos
  var celulasData = document.querySelectorAll('.listaEventos tbody td:nth-child(3)');

  // Iterar sobre as células de data e formatar o conteúdo
  for (var i = 0; i < celulasData.length; i++) {
    var data = celulasData[i].textContent;
    var dataFormatada = formatarData(data);
    celulasData[i].textContent = dataFormatada;
  }
