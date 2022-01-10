# LogParser

The program is designed to process latency data.

Cycle of the program:
- Accepts a text file that contains data about the 
latency time and the name of the object
  - Example
  ![LogParse](https://i.postimg.cc/bv8zsNYz/2022-01-10-11-52-00.png)
  ![LogParser2](https://i.postimg.cc/cJrNKgyG/2022-01-10-11-55-39.png)
- Finds original names and processes latency data
- Calculates minimum, maximum and average latency
- Displays data on the command line as a table

##Example table

name | minLatency | maxLatency | avgLatency
:---: | :---: | :---: | :---:
A|478|637|543
B|305|911|509
C|10|490|263
...|...|...|...

---

# LogParser(рус)

Программа предназначена для обработки данных о задержке.

Цыкл выполнения программы: 
- Принимает текстовый файл, который содержит в себе 
данные о времени задержки и имени объекта
  - Пример
  ![LogParse](https://i.postimg.cc/bv8zsNYz/2022-01-10-11-52-00.png)
  ![LogParser2](https://i.postimg.cc/cJrNKgyG/2022-01-10-11-55-39.png)
- Находит оригинальные имена и обрабатывает данные о задержке
- Вычисляет минимальную, максимальную и среднюю задержки
- Выводит данные в командной строке в виде таблицы
##Пример таблицы 

name | minLatency | maxLatency | avgLatency
:---: | :---: | :---: | :---:
A|478|637|543
B|305|911|509
C|10|490|263
...|...|...|...
