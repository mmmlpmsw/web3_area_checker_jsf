(function () {
  const MIN_Y = -5;
  const MAX_Y = 5;
  const MIN_R = 1;
  const MAX_R = 5;
  const x_Values = [-3, -2, -1, 0, 1, 2, 3, 4, 5];

  let canvasWrapper = document.getElementById("canvas-wrapper");

  let yInput = document.getElementById("form:input_Y");
  let rInput = document.getElementById("form:input_R");
  let xHidden = document.getElementById("form:x-hidden");
  let submitButton = document.getElementById("form:submit-btn");

  let errMsgPanel = document.getElementById('errors-area');
  let graphPicker = new GraphPicker(canvasWrapper, 1000, 1000);

  let savedR = null;

  yInput.innerText='';
  rInput.innerText='';

  //todo
  yInput.value=null;
  rInput.value=null;

  graphPicker.setListener(onGraphClicked);

  function sendDown(msg) {
    errMsgPanel.innerText = msg;
    if (msg != null)
      errMsgPanel.classList.remove("invisible");
    else
      errMsgPanel.classList.add("invisible");
    return false;
  }

  window.onSubmit = () => {
    try {
      yInput.innerText = '';
      rInput.value = savedR;
      rInput.innerText = savedR;
      // rInput.innerText = '';
      return checkR() /*&& checkX(xHidden.value) */&& checkY();
    } catch (e) {
      yInput.innerText = '';
      // rInput.innerText = '';
      console.error(e);
      return false;
    }
  };

  function onGraphClicked(x, y) {
    if(rInput.value === null || rInput.value === 0) {
      sendDown("Не задано значение R.")
    }
    xHidden.value = x;
    yInput.value = y;
    submitButton.click();

    yInput.innerText='';
    rInput.innerText='';
  }

  window.setX = setX;
  function setX(xValue) {
    // if (checkX(xValue)) {
    if (xValue !== null) {
      xHidden.value = xValue;
      graphPicker.setX(xValue);
    }
  }

  window.onYChanged = onYChanged;
  function onYChanged(value) {
    if (checkY()) {
      value = value.replace(',', '.');
      graphPicker.setY(value);
    }
  }

  window.onRChanged = onRChanged;
  function onRChanged(r) {
    if (checkR()) {
      r = r.replace(',', '.');
      graphPicker.setScale(r);
      savedR = r;
      sendDown(null);
    }
      // return sendDown(`R должен лежать в \n (${MIN_R}; ${MAX_R})`);

  }

  function checkX(xValue) {
    if (x_Values.indexOf(+xValue) === -1)
      return sendDown("Аaaaaaaaaaatack");
    return true;
  }

  function checkY() {
    let value = yInput.value.trim();
    if (value.length === 0)
      return sendDown("Следует ввести Y");
    value = value.replace(',', '.');
    if (isNaN(value))
      return sendDown("Y должен\n быть числом");
    if (value.length > 10)
      return sendDown("Y должен содержать\n не более 10\n символов");
    let number = +value;
    if (number <= MIN_Y || number >= MAX_Y)
      return sendDown(`Y должен лежать в \n (${MIN_Y}; ${MAX_Y})`);
    sendDown(null);
    return true;
  }

  function checkR() {
    let rvalue = rInput.value.trim();
    if (rvalue.length === 0)
      return sendDown("Следует ввести R");
    rvalue = rvalue.replace(',', '.');
    if (isNaN(rvalue))
      return sendDown("R должен\n быть числом");
    if (rvalue.length > 6) {
      return sendDown("R должен содержать\n не более\n 6 символов");
    }
    let rnumber = +rvalue;
    if (rnumber <= MIN_R || rnumber >= MAX_R)
      return sendDown(`R должен лежать в \n (${MIN_R}; ${MAX_R})`);
    sendDown(null);
    return true;
  }

  // window.aaaaaaaaaaaaaa = aaaaaaaaaaaaaa;
  // function aaaaaaaaaaaaaa() {
  //     let head = document.head,
  //         link = document.createElement('link');
  //     link.rel = 'stylesheet';
  //
  //     // проверяем значение из localStorage если dark то темная тема
  //     if (localStorage.getItem('themeStyle') === 'dark') {
  //       link.href = 'stylesheet-dark.css'; // ссылка на темный стиль
  //       document.getElementById('switch-1').setAttribute('checked', true); // переключаем чекбокс в положение "темная тема"
  //     }
  //     // по умолчанию светлая тема
  //     else {
  //       link.href = 'stylesheet-light.css'; // ссылка на светлый стиль
  //     }
  //     head.appendChild(link); // вставляем <link rel="stylesheet" href="light|dark.css"> в шапку страницы между темаги head
  //
  //
  //     // событие при переключении чекбокса
  //     document.getElementById('switch-1').addEventListener('change', ev => {
  //       let btn = ev.target;
  //       // если чекбокс включен
  //       if (btn.checked) {
  //         link.href = 'resources/default/styles/stylesheet-dark.css'; // сключаем темную тему
  //         localStorage.setItem('themeStyle', 'dark'); // записываем значение в localStorage
  //       } else {
  //         link.href = 'resources/default/styles/stylesheet-light.css'; // включаем светлую тему
  //         localStorage.setItem('themeStyle', 'light'); // записываем значение в localStorage
  //       }
  //     });
  //
  // }
})();
