package com.parcial.apparquip1.Datos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DConexion(contexto: Context) : SQLiteOpenHelper(contexto, "dbparcial", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE cliente(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, meta TEXT, caracteristicas TEXT)")
        db?.execSQL("CREATE TABLE alimentacion(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, descripcion TEXT, noprocesado TEXT, procesado TEXT)")
        db?.execSQL("CREATE TABLE categoria_ejer(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT)")
        db?.execSQL("CREATE TABLE planEjercicio(id INTEGER PRIMARY KEY AUTOINCREMENT,titulo TEXT,motivo TEXT,objetivo TEXT,video TEXT,proceso TEXT)")
        db?.execSQL(
            "CREATE TABLE plan_categoria(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " id_categoriaEjer INTEGER," +
                    " id_planEjercicio INTEGER, " +
                    "FOREIGN KEY(id_categoriaEjer) REFERENCES categoria_ejer(id),"
                    + "FOREIGN KEY(id_planEjercicio) REFERENCES planEjercicio(id))"
        )
        db?.execSQL(
            "CREATE TABLE rutina(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " titulo TEXT," +
                    " id_planAlimentacion INTEGER," + // Añade una coma aquí
                    "FOREIGN KEY(id_planAlimentacion) REFERENCES alimentacion(id))"
        )
        db?.execSQL(
            "CREATE TABLE rutina_ejercicio(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " id_rutina INTEGER," +
                    " id_planEjercicio INTEGER, " +
                    "FOREIGN KEY(id_rutina) REFERENCES rutina(id)," +
                    "FOREIGN KEY(id_planEjercicio) REFERENCES planEjercicio(id))"
        )

        db?.execSQL(
            """
INSERT INTO cliente (nombre, telefono, meta, caracteristicas) VALUES
('Juan Pérez', '70008213', 'Perder peso', 'Altura: 1.75m, Peso: 85kg, Edad: 30 años'),
('María Rodríguez', '78452415', 'Tonificar', 'Altura: 1.62m, Peso: 58kg, Edad: 28 años'),
('Carlos Gómez', '70008213', 'Ganar masa muscular', 'Altura: 1.80m, Peso: 75kg, Edad: 35 años'),
('Sofía Blanco', '70008213', 'Mejorar resistencia', 'Altura: 1.68m, Peso: 62kg, Edad: 25 años'),
('Pedro Suárez', '78452415', 'Aumentar flexibilidad', 'Altura: 1.85m, Peso: 90kg, Edad: 40 años'),
('Luisa Torres', '67756537', 'Rehabilitación post-lesión', 'Altura: 1.60m, Peso: 55kg, Edad: 32 años');
""".trimIndent()
        )

        db?.execSQL(
            """
INSERT INTO alimentacion (titulo, descripcion, noprocesado, procesado) VALUES
('Dieta Baja en Carbohidratos', 'Plan de alimentación para reducir el consumo de carbohidratos', 'Pollo, Espinaca, Brócoli, Huevos', 'Pan integral, Tortillas de maíz'),
('Dieta Mediterránea', 'Alto en grasas saludables y bajo en alimentos procesados', 'Pescado, Aceite de oliva, Almendras, Tomates', 'Pasta, Pan de centeno'),
('Dieta Vegana', 'Plan de alimentación basado en plantas', 'Tofu, Garbanzos, Lentejas, Espinacas', 'Hamburguesa de soja, Leche de almendras'),
('Dieta Proteica', 'Alta en proteínas para ganar masa muscular', 'Pechuga de pollo, Huevo, Lentejas', 'Proteína en polvo, Barras de proteína'),
('Dieta Detox', 'Plan para desintoxicar el cuerpo', 'Pepino, Apio, Jengibre, Limón', 'Smoothies detox, Jugo verde envasado'),
('Dieta Cetogénica', 'Alta en grasas, muy baja en carbohidratos', 'Aguacate, Carne, Mantequilla, Queso', 'Crema de leche, Snacks cetogénicos'),
('Dieta Paleo', 'Basada en alimentos no procesados', 'Carne magra, Frutas, Verduras, Frutos secos', 'Frutas secas, Yogur natural'),
('Dieta Baja en Grasas', 'Reducir el consumo de grasas y calorías', 'Pechuga de pavo, Espárragos, Frutas', 'Galletas de arroz, Yogur bajo en grasa');

""".trimIndent()
        )

        db?.execSQL(
            """
INSERT INTO categoria_ejer (nombre, descripcion) VALUES
('Cardio', 'Ejercicios que aumentan la frecuencia cardíaca, ideales para quemar calorías.'),
('Fuerza', 'Ejercicios para mejorar la fuerza muscular, generalmente con pesas.'),
('Flexibilidad', 'Ejercicios que mejoran la flexibilidad y el rango de movimiento.'),
('Resistencia', 'Ejercicios que ayudan a aumentar la resistencia física.'),
('Entrenamiento funcional', 'Ejercicios que imitan movimientos cotidianos.'),
('Yoga', 'Práctica que combina ejercicios físicos con respiración y meditación.'),
('Pilates', 'Sistema de ejercicios que fortalecen el cuerpo sin aumentar el volumen muscular.'),
('HIIT', 'Entrenamiento de intervalos de alta intensidad.'),
('Ciclismo', 'Ejercicios relacionados con la práctica de andar en bicicleta.'),
('Natación', 'Ejercicio realizado en el agua que trabaja todo el cuerpo.');

""".trimIndent()
        )

        db?.execSQL(
            """
INSERT INTO planEjercicio (titulo, motivo, objetivo, video, proceso) VALUES
('Plan de Pérdida de Peso', 'Perder peso de forma saludable', 'Bajar 5 kg en 2 meses', 'https://youtu.be/5uFpo7KHOrI?si=Vu_0LtMkao5jLmwc', 'Ejercicios de cardio 30 min, 5 días a la semana'),
('Plan de Fuerza Total', 'Aumentar masa muscular', 'Ganar 3 kg de masa muscular en 3 meses', 'https://youtu.be/UqB65gs_Lr0?si=31FJNS3ipK_j89z5', 'Entrenamiento de fuerza 4 días a la semana'),
('Plan de Resistencia', 'Prepararse para correr una carrera de 10 km', 'Correr 10 km en menos de 60 min', 'https://youtu.be/aKHar4U2Iys?si=NsBMp8ELjR2uk5-a', 'Entrenamiento de resistencia 5 días a la semana'),
('Plan de Flexibilidad', 'Mejorar la flexibilidad y el rango de movimiento', 'Realizar el split completo en 3 meses', 'https://youtu.be/cwH52piEl8A?si=JQVF9yCeLVkDbYLD', 'Ejercicios de estiramiento 5 días a la semana'),
('Plan de HIIT', 'Entrenamiento de alta intensidad para quemar grasa', 'Bajar 2 kg en 1 mes', 'https://youtu.be/cwH52piEl8A?si=JQVF9yCeLVkDbYLD', 'HIIT 4 veces a la semana'),
('Plan de Entrenamiento Funcional', 'Mejorar fuerza y resistencia para actividades diarias', 'Aumentar la energía en las tareas diarias', 'https://youtu.be/aKHar4U2Iys?si=NsBMp8ELjR2uk5-a', 'Entrenamiento funcional 3 días a la semana'),
('Plan de Yoga', 'Aumentar la flexibilidad y reducir el estrés', 'Practicar yoga 3 veces a la semana', 'https://youtu.be/0Grvq1Kz6L8?si=Orpd0OAFTTaGtUOU', 'Sesiones de 1 hora, 3 veces por semana'),
('Plan de Natación', 'Mejorar la técnica y resistencia en natación', 'Nadar 1 km sin parar', 'https://youtu.be/2PVk2wUY04k?si=04JLMg41I6zrGqrN', 'Entrenamiento de natación 2 días a la semana');

""".trimIndent()
        )

        db?.execSQL(
            """
INSERT INTO plan_categoria (id_categoriaEjer, id_planEjercicio) VALUES
(1, 1), -- Cardio -> Plan de Pérdida de Peso
(2, 2), -- Fuerza -> Plan de Fuerza Total
(4, 3), -- Resistencia -> Plan de Resistencia
(3, 4), -- Flexibilidad -> Plan de Flexibilidad
(8, 5), -- HIIT -> Plan de HIIT
(5, 6), -- Entrenamiento funcional -> Plan de Entrenamiento Funcional
(7, 7), -- Yoga -> Plan de Yoga
(9, 8); -- Ciclismo -> Plan de Natación

""".trimIndent()
        )

        db?.execSQL(
            """
INSERT INTO rutina (titulo, id_planAlimentacion) VALUES
('Rutina de Pérdida de Peso', 1), 
('Rutina de Fuerza Total', 2), 
('Rutina de Resistencia', 3), 
('Rutina de Flexibilidad', 4), 
('Rutina de HIIT', 5), 
('Rutina Funcional', 6), 
('Rutina de Yoga', 7), 
('Rutina de Natación', 8), 
('Rutina de Ciclismo', 9), 
('Rutina de Entrenamiento en Casa', 1);

""".trimIndent()
        )

        db?.execSQL(
            """
INSERT INTO rutina_ejercicio (id_rutina, id_planEjercicio) VALUES
(1, 1), -- Rutina de Pérdida de Peso -> Plan de Pérdida de Peso
(2, 2), -- Rutina de Fuerza Total -> Plan de Fuerza Total
(3, 3), -- Rutina de Resistencia -> Plan de Resistencia
(4, 4), -- Rutina de Flexibilidad -> Plan de Flexibilidad
(5, 5), -- Rutina de HIIT -> Plan de HIIT
(6, 6), -- Rutina Funcional -> Plan de Entrenamiento Funcional
(7, 7), -- Rutina de Yoga -> Plan de Yoga
(8, 8), -- Rutina de Natación -> Plan de Natación
(9, 9), -- Rutina de Ciclismo -> Plan de Ciclismo
(10, 1); -- Rutina de Entrenamiento en Casa -> Plan de Pérdida de Peso

""".trimIndent()
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS cliente")
        db?.execSQL("DROP TABLE IF EXISTS alimentacion")
        db?.execSQL("DROP TABLE IF EXISTS categoria_ejer")
        db?.execSQL("DROP TABLE IF EXISTS planEjercicio")
        db?.execSQL("DROP TABLE IF EXISTS plan_categoria")
        db?.execSQL("DROP TABLE IF EXISTS rutina_ejercicio")
        db?.execSQL("DROP TABLE IF EXISTS rutina")
        onCreate(db)
    }
}