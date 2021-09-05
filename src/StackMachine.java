package es.uned.lsi.eped.pract2018_2019;
import es.uned.lsi.eped.DataStructures.BTreeIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.QueueIF;
import es.uned.lsi.eped.DataStructures.Stack;

public class StackMachine {

	/*Declaramos una pila de operandos.*/
	protected Stack<Operand> pila_operandos;
	
	public StackMachine() {
		pila_operandos = new Stack<Operand>();
	}
	
	/*Este m�todo recibe un �rbol sint�ctico, lo recorre en postorden
	 * eval�a la expresi�n y devuelve el resultado de dicha evaluaci�n.
	 * Si se trata de un nodo operando, se apila en la pila de operandos.
	 * Si se trata de un nodo operador, la m�quina extrae dos operandos de la pila,
	 * calcula el resultado y apila el resultado en la pila.*/
	public Operand execute(SynTree syn) {
		pila_operandos.clear();
		Queue<Node> cola_auxiliar = new Queue<Node>();
		postorder(syn.getSynTree(), cola_auxiliar);
		int tamano_cola = cola_auxiliar.size();
		
		//Coger la cola auxiliar (los nodos, que ya estar�n en notaci�n postfija), y evaluar las expresiones.
		for(int i=0; i<tamano_cola; i++){
			if(cola_auxiliar.getFirst().getNodeType() == Node.NodeType.OPERAND){
				pila_operandos.push((Operand)cola_auxiliar.getFirst());
			}else if(cola_auxiliar.getFirst().getNodeType() == Node.NodeType.OPERATOR) {
				Operator ot = (Operator)cola_auxiliar.getFirst();
				Operand o2 = pila_operandos.getTop(); pila_operandos.pop();
				Operand o1 = pila_operandos.getTop(); pila_operandos.pop();
				switch(ot.getOperatorType()){
					case ADD: o1.add(o2); break;
					case SUB: o1.sub(o2); break;
					case MULT: o1.mult(o2); break;
				}
				pila_operandos.push(o1);
			}
			cola_auxiliar.dequeue();
		}
		
		
		return (new Operand(pila_operandos.getTop().toString()));
	}
	
	
	/*Recorre el �rbol en postorden, de forma recursiva */
	private void postorder(BTreeIF<Node> t, QueueIF<Node> q) {
		if ( !t.isEmpty() ) {
			if ( t.getLeftChild() != null ) { postorder(t.getLeftChild(),q); }
			if ( t.getRightChild() != null ) { postorder(t.getRightChild(),q); }
			q.enqueue(t.getRoot());
		}
	}
	
}
