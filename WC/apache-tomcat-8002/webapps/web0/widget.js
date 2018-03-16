function loadWidget(label) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var elem = document.getElementById(label);
			elem.attachShadow({mode : 'open'});					
			elem.shadowRoot.innerHTML = this.responseText;	
		}
	};
	xhttp.open("GET", "http://localhost:8080/web0/s4/"+label+".html", true);
	xhttp.send();
}

function test(label) {
	document.body.appendChild(new Text(label));
}
