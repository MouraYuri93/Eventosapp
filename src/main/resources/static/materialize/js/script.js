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
  //Mask CPF
   document.getElementById('identification').addEventListener('input', function(e) {
      let x = e.target.value.replace(/\D/g, '').match(/(\d{0,3})(\d{0,3})(\d{0,3})(\d{0,2})/);
        e.target.value = !x[2] ? x[1] : x[1] + '.' + x[2] + (x[3] ? '.' : '') + x[3] + (x[4] ? '-' + x[4] : '');

        console.log('Com formatação: ' + e.target.value);

        // Caso queira pegar apenas os números use essa função para remover todos os caracteres menos os números em Js
        let valor = e.target.value.replace(/[^0-9]/g, '');
        console.log('Sem formatação: ' + valor);
   });