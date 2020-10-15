# Menus
Ejemplo de menú e interacción de 4 formas:

1) haciendo click sobre los puntos => Muestra menú de acciones. Las acciones 2 y la 3 se incrustan desde el xml [menu.xml]. La acción 4 se incrusta programáticamente sobreescribiendo onCreateOptionsMenu(Menu menu).

2) manteniendo pulsado los tres puntos  => Muestra “More options”

3) haciendo click sobre la XOR. => Muestra Toast “Accion 1”

4) manteniendo pulsado sobre el Textview con texto “menú contextual” =>Muestra menú contextual con opción contextual 1 y 2 [menu_contextual.xml].  Uso de registerForContextMenu(textView) en onCreate.


Las acción de seleccionar un ítem del menú desata la ejecución de métodos a sobreescribir:

- menú de puntos:  onOptionsItemSelected

- menú contextual: onContextItemSelected

