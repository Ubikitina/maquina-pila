package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.Stack;

public class ValueSeq extends Value {

	/* Atributo que guarda el valor numérico */
	private Stack<Integer> pila_valores;
	
	/* Constructor: recibe un String con el valor numérico */
	public ValueSeq(String s) {
		this.pila_valores = new Stack<Integer>();
		
		for (int i = 0; i<s.length(); i++) {
			Integer digito = Integer.parseInt(String.valueOf(s.charAt(i)));
			this.pila_valores.push(digito);
		}
		
	}
	
	/* Método que transforma el valor numérico en un String */
	public String toString() {
		String resultado = "";
		resultado = toStringRecursivo(resultado);
		return resultado;
	}
	
	/*Metodo recursivo toString*/
	private String toStringRecursivo(String r) {
		if(this.pila_valores.size()>0) {
			r = "" + Integer.toString(this.pila_valores.getTop()) + r;
			int cima = this.pila_valores.getTop();
			this.pila_valores.pop();
			r = toStringRecursivo(r);
			this.pila_valores.push(cima);
		}
		return r;
	}
	
	/*Metodo para dar la vuelta a una pila*/
	private Stack<Integer> reverseStack(Stack<Integer> s){
		Stack<Integer> copy = new Stack<Integer>(s);
		Stack<Integer> result = new Stack<Integer>();
		while(!copy.isEmpty()) {
			result.push(copy.getTop());
			copy.pop();
		}
		return result;
	}

	/* Método que modifica el valor numérico llamante, sumándole el valor numérico parámetro */
	public void addValue(Value n) {
		Stack<Integer> pilaAuxiliar = new Stack<Integer>(((ValueSeq)n).pila_valores);
		Stack<Integer> pilaResultado = new Stack<Integer>();
		Integer carry = 0;
		
		pilaResultado = addValueRecursivo(pilaAuxiliar, pilaResultado, carry);
		this.pila_valores = reverseStack(pilaResultado);
		
	}
	
	/*Metodo recursivo addValue*/
	private Stack<Integer> addValueRecursivo(Stack<Integer> p_aux, Stack<Integer> p_res, Integer car) {
		Integer suma = 0;
		Integer sumando1 = 0;
		Integer sumando2 = 0;
		
		//Calculamos sumando 1
		switch(this.pila_valores.size()){
			case  0:  sumando1 = 0; break;
			default: sumando1 = this.pila_valores.getTop(); this.pila_valores.pop(); break;
		}
		
		//Calculamos sumando 2
		switch(p_aux.size()){
		case  0:  sumando2 = 0; break;
		default: sumando2 = p_aux.getTop(); p_aux.pop(); break;
		}
		
		//Se realiza la suma
		suma = sumando1+sumando2+car;
		
		//Calculamos el carry
		car = 0;
		if(suma > 9) {
			car = 1;
			suma = suma-10;
		}
		//Se aniade a la pila de resultado
		p_res.push(suma);

		//Evalua si las dos pilas se han vaciado. Si no, llamada recursiva.
		if(this.pila_valores.size() == 0 && p_aux.size() == 0) {
			if(car==1) {
				suma = car;
				p_res.push(suma);
			}
		}else {
			p_res = addValueRecursivo(p_aux, p_res, car);
		}
		
		return p_res;
	}

	/* Método que modifica el valor numérico llamante, restándole el valor numérico parámetro */
	public void subValue(Value n) {
		Stack<Integer> pilaAuxiliar = new Stack<Integer>(((ValueSeq)n).pila_valores);
		Stack<Integer> pilaResultado = new Stack<Integer>();
		Integer carry = 0;
		
		pilaResultado = subValueRecursivo(pilaAuxiliar, pilaResultado, carry);
		//Quitamos los 0-s a la izquierda.
		while(pilaResultado.size()>1 && pilaResultado.getTop()==0) {
			pilaResultado.pop();
		}
		this.pila_valores = reverseStack(pilaResultado);
	}
	
	/*Metodo recursivo subValue*/
	private Stack<Integer> subValueRecursivo(Stack<Integer> p_aux, Stack<Integer> p_res, Integer car) {
		Integer resta = 0;
		Integer restador1 = 0;
		Integer restador2 = 0;
		
		//Calculamos restador 1
		switch(this.pila_valores.size()){
			case  0:  restador1 = 0; break;
			default: restador1 = this.pila_valores.getTop(); this.pila_valores.pop(); break;
		}
		
		//Calculamos restador 2
		switch(p_aux.size()){
		case  0:  restador2 = 0; break;
		default: restador2 = p_aux.getTop(); p_aux.pop(); break;
		}

		//Se realiza la resta
		resta = restador1-restador2-car;
		
		//Calculamos el carry
		car = 0;
		if(resta < 0) {
			car = 1;
			resta = resta+10;
		}
		//Se aniade a la pila de resultado
		p_res.push(resta); 

		//Evalua si las dos pilas se han vaciado. Si no, llamada recursiva.
		if(this.pila_valores.size() == 0 && p_aux.size() == 0) {
			if(car==1) {
				resta = car;
				p_res.push(resta);
			}
		}else {
			p_res = subValueRecursivo(p_aux, p_res, car);
		}
		
		return p_res;
	}

	/* Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro */
	public void subFromValue(Value n) {
		Stack<Integer> pilaAuxiliar = new Stack<Integer>(((ValueSeq)n).pila_valores);
		Stack<Integer> pilaResultado = new Stack<Integer>();
		Integer carry = 0;
		
		pilaResultado = subFromValueRecursivo(pilaAuxiliar, pilaResultado, carry);
		//Quitamos los 0-s a la izquierda.
		while(pilaResultado.size()>1 && pilaResultado.getTop()==0) {
			pilaResultado.pop();
		}
		this.pila_valores = reverseStack(pilaResultado);
	}
	
	/*Metodo recursivo subValue*/
	private Stack<Integer> subFromValueRecursivo(Stack<Integer> p_aux, Stack<Integer> p_res, Integer car) {
		Integer resta = 0;
		Integer restador1 = 0;
		Integer restador2 = 0;
		
		//Calculamos restador 1
		switch(this.pila_valores.size()){
			case  0:  restador1 = 0; break;
			default: restador1 = this.pila_valores.getTop(); this.pila_valores.pop(); break;
		}
		
		//Calculamos restador 2
		switch(p_aux.size()){
		case  0:  restador2 = 0; break;
		default: restador2 = p_aux.getTop(); p_aux.pop(); break;
		}

		//Se realiza la resta
		resta = restador2-restador1-car; 
		
		//Calculamos el carry
		car = 0;
		if(resta < 0) {
			car = 1;
			resta = resta+10;
		}
		//Se aniade a la pila de resultado
		p_res.push(resta); 

		//Evalua si las dos pilas se han vaciado. Si no, llamada recursiva.
		if(this.pila_valores.size() == 0 && p_aux.size() == 0) {
			if(car==1) {
				resta = car;
				p_res.push(resta);
			}
		}else {
			p_res = subFromValueRecursivo(p_aux, p_res, car);
		}
		
		return p_res;
	}

	/* Método que modifica el valor numérico llamante, multiplicándolo por el valor numérico parámetro */
	public void multValue(Value n) {
		Stack<Integer> pilaAuxiliar = new Stack<Integer>(((ValueSeq)n).pila_valores);
		
		//Si minimo una de las dos pilas esta vacia o es 0, el resultado sera 0.
		if(pilaAuxiliar.isEmpty()||this.pila_valores.isEmpty()|| pilaAuxiliar.size()==1 && pilaAuxiliar.getTop()==0 ||
				this.pila_valores.size()==1 && this.pila_valores.getTop()==0) {
			this.pila_valores.clear();
			this.pila_valores.push(0);
		
		}else {
			//Definimos los digitos y las listas de los operandos a multiplicar y almacenar el resultado.
			int digito1 = 0;
			int digito2 = 0;
			int multSum = 0;
			int carry = 0;
			List<Integer> operando1 = new List<Integer>(fromStacktoList(this.pila_valores));
			List<Integer> operando2 = new List<Integer>(fromStacktoList(pilaAuxiliar));
			List<Integer> resultado = new List<Integer>();
			//Indices para buscar posiciones en las listas
			int indx1 = 1;
			int indx2 = 1;
			
			//Inicializamos el resultado a 0
			for(int h = 1; h<=(operando1.size()+operando2.size()); h++) {
				resultado.insert(h, 0);
			}

			
			/*PRIMER FOR: Avanza digito2*/
			for(int i = 1; i<=operando2.size(); i++) {
				
				carry = 0;
				indx1 = 1;
				//Obtenemos digito2 a multiplicar
				digito2 = operando2.get(i);
				
				
			    /*SEGUNDO FOR: Avanza digito1*/
			    for(int j = 1; j<=operando1.size(); j++) {
				    //Obtenemos los digito1 a multiplicar
				    digito1 = operando1.get(j);
				    
				    //Realizamos la multiplicacion y sumamos la columna
				    multSum = digito1*digito2 + resultado.get(indx1+indx2-1) + carry;
				    
				    //Calculamos carry para la siguiente
				    carry = multSum/10;
				    
				    //Guardamos el digito-resultado en la lista-resultado
				    resultado.set(indx1+indx2-1, multSum%10);
				    
				    indx1++;
			    }
			    
			    //Guardamos el carry en la siguiente posicion
			    if(carry>0) {
			    	resultado.set(indx1+indx2-1, carry);
			    }
			    
			    //Actualizamos las posiciones a la izquierda
			    indx2++;
			}
			
			//Paso el resultado a la pila_valores
			this.pila_valores = fromListtoStack(resultado);
		}
		
	}
	
	/*Metodo que recibe una pila y devuelve una lista*/
	private List<Integer> fromStacktoList(Stack<Integer> s){
		Stack <Integer> sCopy = new Stack<Integer>(s);
		List<Integer> l = new List<Integer>();
		int pos = 1;
		
		while(!sCopy.isEmpty()) {
			l.insert(pos, sCopy.getTop());
			sCopy.pop();
			pos++;
		}
		
		return l;
	}
	
	/*Metodo que recibe una lista y devuelve una pila*/
	private Stack<Integer> fromListtoStack(List<Integer> l){
		Stack <Integer> s = new Stack<Integer>();
		
		//Quitamos los 0-s a la izquierda.
		while(l.size()>1 && l.get(l.size())==0) {
			l.remove(l.size());
		}
		
		//Metemos en la pila
		for(int i = l.size(); i>= 1; i--) {
			s.push(l.get(i));
		}
		
		return s;
	}

	/* Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro (n)*/
	public boolean greater(Value n) { 
		if(this.pila_valores.size()>((ValueSeq)n).pila_valores.size()) {
			return true;
			
		}else if(this.pila_valores.size()==((ValueSeq)n).pila_valores.size()) {
			Stack<Integer> copia_pila_valores = new Stack<Integer>(reverseStack(this.pila_valores));
			Stack<Integer> copia_pila_parametro = new Stack<Integer>(reverseStack(((ValueSeq)n).pila_valores));
			
			while((!copia_pila_valores.isEmpty() && copia_pila_valores.getTop()==copia_pila_parametro.getTop())) {
				copia_pila_valores.pop();
				copia_pila_parametro.pop();
			}
			if(!copia_pila_valores.isEmpty() && copia_pila_valores.getTop()>copia_pila_parametro.getTop()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	/* Método que indica si el valor numérico es cero */
	public boolean isZero() {
		if(this.pila_valores.size()==1 && this.pila_valores.getTop() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/*Metodo que implementa la multiplicacien mediante sumas sucesivas - Ejercicio 4 de la memoria*/
	public void multiplicarEj4(Value n) {
		Stack<Integer> pilaAuxiliar = new Stack<Integer>(((ValueSeq)n).pila_valores);
		
		//Si minimo una de las dos pilas esta vacia o es 0, el resultado sera 0.
		if(pilaAuxiliar.isEmpty()||this.pila_valores.isEmpty()|| pilaAuxiliar.size()==1 && pilaAuxiliar.getTop()==0 ||
				this.pila_valores.size()==1 && this.pila_valores.getTop()==0) {
			this.pila_valores.clear();
			this.pila_valores.push(0);
		
		}else {
			
			//Vemos que numero es el mayor y que numero es el menor
			ValueSeq higherValue;
			ValueSeq lowerValue;
			
			if(this.greater(n)) {
				higherValue = this;
				lowerValue = (ValueSeq) n;
			}else {
				higherValue = (ValueSeq) n;
				lowerValue = this;
			}
			
			//Realizamos las sumas sucesivas
			ValueSeq aux = new ValueSeq(higherValue.pila_valores);
			
			while(!lowerValue.pila_valores.isEmpty() && !(lowerValue.pila_valores.size()==1 && lowerValue.pila_valores.getTop()==1)) {
				aux.addValue(higherValue);
				lowerValue.subValue(new ValueSeq ("1"));
			}
			
			this.pila_valores = aux.pila_valores;
		}
		
	}
	
	/* Constructor: recibe una pila, utilizado para el ejercicio 4 */
	public ValueSeq(Stack<Integer> s) {
		this.pila_valores = new Stack<Integer>(s);
			
	}
	
}
