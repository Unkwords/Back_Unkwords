--usuarios
INSERT INTO usuarios(nombre,apellido,contrasena,username,email,role) values ('camilo','rodriguez','camilo123','camilo123','camilo@gmail.com','USUARIO');
INSERT INTO usuarios(nombre,apellido,contrasena,username,email,role) values ('andrea','marin','andrea123','andrea123','andrea@gmail.com','USUARIO');
INSERT INTO usuarios(nombre,apellido,contrasena,username,email,role) values ('john','villa','john123','john123    ','john@gmail.com','USUARIO');

--palabras
INSERT INTO palabras(tipo,origen,palabra,num_likes) values('Adjetivo','Colombia','Varado',0);
INSERT INTO palabras(tipo,origen,palabra,num_likes) values('Adjetivo','Colombia','Casposo',0);
INSERT INTO palabras(tipo,origen,palabra,num_likes) values('Adjetivo','Colombia','Embalado',0);

--significados
INSERT INTO significados_palabra(palabra_id,significado) values (1L,'Vehículo que dejó de funcionar.');
INSERT INTO significados_palabra(palabra_id,significado) values (1L,'Persona que no tiene dinero en el momento para comprar algo que necesita.');
INSERT INTO significados_palabra(palabra_id,significado) values (1L,'Que no tiene trabajo o esta desocupado.');

INSERT INTO significados_palabra(palabra_id,significado) values (2L,'Habla mucha bobada o lo que hablo no tiene sentido.');
INSERT INTO significados_palabra(palabra_id,significado) values (2L,'Que no es amable, tiene una mala actitud.');

INSERT INTO significados_palabra(palabra_id,significado) values (3L,'Estar en problemas, apuros o aprietos.');
INSERT INTO significados_palabra(palabra_id,significado) values (3L,'Que va muy rapido con un medio de transporte ya sea bicicleta, carro, moto etc.');
INSERT INTO significados_palabra(palabra_id,significado) values (3L,'Haberte fumado algo.');

--ejemplos
INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (1L,'Ese carro está varado en mitad de la vía.');
INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (1L,'Estoy varado, no tengo (dinero) para el almuerzo.');
INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (1L,'Me encuentro varado en este momento, no consigo empleo');

INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (2L,'Juan es muy casposo');
INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (2L,'Ese man no me cayó bien, es como casposo.');

INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (3L,'ayudame, estoy embalado.');
INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (3L,'ushh ese pribobo paso rre embalado.');
INSERT INTO ejemplos_palabra(palabra_id,ejemplo) values (3L,'Tu estás embalado( osea que te fumaste algo).');