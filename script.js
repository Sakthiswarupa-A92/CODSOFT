let inputbox = document.getElementById('inputarea')
let buttons = document.querySelectorAll('buttons')

let string = ''
buttons.forEach(element =>{
	element.addEventListener('click',(b)=>{
		if(b.target.innerText == '='){
			string = String(eval(string))
			inputBox.value = string;
		}
		else if(b.target.innerTest == 'AC'){
			string = ''
			inputBox.value = string;
		}
		else if(b.target.innerTest == 'C'){
			string = String.substring(0,string.length-1);
			inputBox.value = string;
		}
		else if(b.target.innerTest == 'plusminusButton'){
			string = String(-eval(string))
			inputBox.value = string;
		}
		else {
			string += b.target.innerTest
			inputBox.value = string;
		}

	})
})