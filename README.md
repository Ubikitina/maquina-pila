# Objetivo maquina-pila
Trabajo desarrollado en la asignatura Estrategias de Programación y Estructuras de Datos (EPED) en el Grado de Ingeniería Informática de la UNED. Consiste en crear una máquina pila capaz de evaluar expresiones formadas por sumas, restas y multiplicaciones de enteros de tamaño ilimitado, superándo el límite de los números long de 64 bits (de -9223372036854775808 a +9223372036854775807).

Dicha máquina recibirá el árbol sintáctico de la expresión y deberá devolver un valor entero con el resultado. Por ejemplo, para la expresión `4 + (5 * (2 - (-1)))` el resultado es `19`.

**Notas a tener en cuenta**:
- El proceso de construcción del árbol sintáctico queda fuera del alcance de la asignatura, por lo que el Equipo Docente ha proporcionado todas las clases necesarias para realizar esta parte. Dichas clases no se han subido al repositorio, al no ser desarrollos propios. Para más detalle, ver sección _Clases y juegos de prueba proporcionados por el equipo docente_.
- Como parte de los requisitos del enunciado, no se permite el uso de iteradores, por lo que las secuencias de dígitos que representan un entero deberán ser recorridas preservando su estructura de forma adecuada.

# Código desarrollado
El enunciado requiere realizar dos implementaciones diferentes:
1. **Parte 1: Máquina pila**: Se trata de una clase llamada `StackMachine.java`, en la que se ha desarrollado la máquina pila y se ha probado inicialmente con la implementación de enteros que usa el tipo `int` de Java.
2. **Parte 2: Secuencias de dígitos**: Se trata de la clase llamada `ValueSeq.java` que implementa las operaciones de enteros sobre secuencias de dígitos, lo cual permitirá que la misma máquina pila (desarrollada en la parte 1) opere con enteros de precisión ilimitada. Esta implementación emplea una secuencia de dígitos para almacenar enteros de precisión ilimitada (salvo por la propia memoria del ordenador).

En las siguientes secciones se detalla cada implementación.

## Parte 1: Máquina pila


## Parte 2: Secuencias de dígitos


# Clases y juegos de prueba proporcionados por el equipo docente
:warning: _El material del equipo docente no se ha subido a este repositorio al no tratarse del autor del repositorio. Sin embargo, a modo informativo, a continuación se detalla la descripción de los recursos provistos._

Las **clases** proporcionadas por el equipo docente han sido:
- **Carpeta `src/DataStructures` y todas las clases en el interior**: Se trata de las estructuras de datos necesarias para la práctica. Se compone exactamente de las clases: `BSTreeIF.java`, `BTree.java`, `BTreeIF.java`, `Collection.java`, `CollectionIF.java`, `ContainerIF.java`, `GTree.java`, `GTreeIF.java`, `IteratorIF.java`, `List.java`, `ListIF.java`, `MultiSetIF.java`, `Queue.java`, `QueueIF.java`, `Sequence.java`, `SequenceIF.java`, `SetIF.java`, `Stack.java`, `StackIF.java`, `Test.java`, `Tree.java` y `TreeIF.java`.
- **Carpeta `src/pract2018_2019`**: 
  - `Main.java`: Clase con la función principal main donde el programa comienza su ejecución.
  - `Node.java`: Clase abstracta que define un tipo enumerado. Se encarga de agrupar los dos tipos de nodos (OPERATOR y OPERAND) que vamos a considerar en el árbol binario donde representaremos nuestro árbol sintáctico.
  - `Operand.java`: Esta clase extiende (hereda de) la clase Node. Define un operando como un valor entero que se almacena mediante un objeto de la clase Value (ver abajo esta clase) y un signo almacenado mediante un byte (puede ser -1 para enteros negativos, +1 para enteros positivos y 0 para el 0).
  - `Operator.java`: Esta clase extiende (hereda de) la clase Node. Define un tipo enumerado con los tres diferentes operadores que vamos a considerar (ADD, SUB y MULT) y un constructor que recibe como parámetro el tipo de operador que representa.
  - `SynTree.java`: Se encarga de la creación del árbol sintáctico a partir de las expresiones. Su constructor recibe una cadena de caracteres conteniendo la expresión en notación prefija. El árbol sintáctico se representa mediante una estructura de árbol binario en el que los nodos intermedios van a contener operadores y las hojas operandos.
  - `Value.java`: Representa valores enteros sin signo. Como se van a utilizar dos representaciones diferentes (int y secuencias de dígitos), esta clase es abstracta y será implementada por clases no abstractas `ValueInt.java` y `ValueSeq.java`.
  - `ValueInt.java`: Esta clase extiende (hereda de) Value. Sus objetos son valores enteros (sin signo) representados mediante el tipo int de Java.

Además, el equipo docente también ha proporcionado **juegos de prueba** para que los estudiantes puedan comprobar el correcto funcionamiento del programa. Los juegos de prueba se ejecutan a través de un script `Compile_Run_Test_V.05.bat`, el cual carga las pruebas listadas en los archivos `Estudiantes_INT.txt` y `Estudiantes_SEQ.txt` (ver estos dos archivos en la carpeta [juego_de_pruebas](juego_de_pruebas)).
