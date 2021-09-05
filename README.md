# Objetivo maquina-pila
Trabajo desarrollado en la asignatura Estrategias de Programación y Estructuras de Datos (EPED) en el Grado de Ingeniería Informática de la UNED. Consiste en crear una máquina pila capaz de evaluar expresiones formadas por sumas, restas y multiplicaciones de enteros de tamaño ilimitado, superándo el límite de los números long de 64 bits (de -9223372036854775808 a +9223372036854775807).

Dicha máquina recibirá el árbol sintáctico de la expresión y deberá devolver un valor entero con el resultado. Por ejemplo, para la expresión `4 + (5 * (2 - (-1)))` el resultado es `19`.

**Notas a tener en cuenta**:
- El proceso de construcción del árbol sintáctico queda fuera del alcance de la asignatura, por lo que el Equipo Docente ha proporcionado todas las clases necesarias para realizar esta parte. Dichas clases no se han subido al repositorio, al no ser desarrollos propios. Para más detalle, ver sección Clases proporcionadas por el equipo docente.
- Como parte de los requisitos del enunciado, no se permite el uso de iteradores, por lo que las secuencias de dígitos que representan un entero deberán ser recorridas preservando su estructura de forma adecuada.

## Clases y juegos de prueba proporcionados por el equipo docente
:warning: _El material del equipo docente no se ha subido a este repositorio al no tratarse del autor del repositorio. Sin embargo, a modo informativo, a continuación se detalla la descripción de los recursos provistos._

Las **clases** proporcionadas por el equipo docente han sido:
- **Carpeta `src/DataStructures` y todas las clases en el interior**: `BSTreeIF.java`, `BTree.java`, `BTreeIF.java`, `Collection.java`, `CollectionIF.java`, `ContainerIF.java`, `GTree.java`, `GTreeIF.java`, `IteratorIF.java`, `List.java`, `ListIF.java`, `MultiSetIF.java`, `Queue.java`, `QueueIF.java`, `Sequence.java`, `SequenceIF.java`, `SetIF.java`, `Stack.java`, `StackIF.java`, `Test.java`, `Tree.java` y `TreeIF.java`.
- **Carpeta `src/pract2018_2019`**: `Main.java`, `Node.java`, `Operand.java`, `Operator.java`, `SynTree.java`, `Value.java` y `ValueInt.java`.

Además, el equipo docente también ha proporcionado **juegos de prueba** para que los estudiantes puedan comprobar el correcto funcionamiento del programa. Los juegos de prueba se ejecutan a través de un script `Compile_Run_Test_V.05.bat`, el cual carga las pruebas listadas en los archivos `Estudiantes_INT.txt` y `Estudiantes_SEQ.txt` (ver estos dos archivos en la carpeta `maquina-pila/juego_de_pruebas`).
