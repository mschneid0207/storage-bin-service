insert into warehouse (id, name, description, location) values (100, 'Werkzeuglager BML', 'Automatisches Lager für Presswerkzeuge
 und Schweisszangen', 'Dingolfing');

insert into storage_bin (id, corridor, rack, level, section, warehouse_id) values (1000, 15, 12, 3, 11, 100);
insert into storage_bin (id, corridor, rack, level, section, warehouse_id) values (1001, 13, 9, 1, 12, 100);
insert into storage_bin (id, corridor, rack, level, section, warehouse_id) values (1002, 1, 1, 1, 12, 100);


