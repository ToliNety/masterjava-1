# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия (скачать все патчи можно через Download папки patch)](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFei05cGNKbEM3eG8) 

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW4

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Сохранение в базу в batch-моде с обработкой конфликтов](https://drive.google.com/file/d/0B9Ye2auQ_NsFZEJwR2ZqMEdVRG8)

#### 5_1_HW4_export_chunk.patch
#### 5_2_HW4_webapp_users.patch
#### 5_3_HW4_already_present.patch
#### 5_4_HW4_parallel.patch

----------------

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZ3VZMlFITkk0LXM">Конфигурирование приложения</a>
#### 5_5_typesafe_config.patch
> Не забудте положить `persist.conf` в `/apps/masterjava/config` (или убрать `required` из `persist\src\main\resources\persist.conf`) 

- <a href="http://springtips.blogspot.ru/">Переопределение занчений в конфигурации в Spring</a>. 
- <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html#howto-change-configuration-depending-on-the-environment">Встроенные профили Spring Boot</a>
- <a href="http://commons.apache.org/proper/commons-configuration/index.html">Apache commons-configuration2</a>
- <a href="https://github.com/typesafehub/config">Typesafe config library </a>, user in <a href="https://www.playframework.com/documentation/2.5.x/ConfigFile">Playframework</a>
 - <a href="https://github.com/typesafehub/config/blob/master/HOCON.md">HOCON Syntax</a>: Include, required(), Substitutions 

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFc3p3QTVwYktBWUk">Lombook</a>
#### 5_6_lombook.patch
- Подключаем <a href="https://habrahabr.ru/post/142356/">Lombok</a>
- <a href="https://urvanov.ru/2015/09/22/project-lombok/">Фичи Lombook</a>
- <a href="https://github.com/mplushnikov/lombok-intellij-plugin">Подключение к IDEA</a>
- <a href="http://stackoverflow.com/questions/3852091/is-it-safe-to-use-project-lombok">Drawbacks</a>, <a href="http://stackoverflow.com/a/29771875/548473">Call super constructor</a>
- <a href="https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/">Declutter Your POJOs with Lombok</a>

## Домашнее задание
- добавить в DB города, группы и проекты
- добавить в модуль **export** импорт и сохранение в базу городов и групп/проектов.

#### Optional
- добавить при импорте пользователей связи на города/группы.