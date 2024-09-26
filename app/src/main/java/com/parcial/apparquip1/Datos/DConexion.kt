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
    ('Carlos López', '67756537', 'Perder peso', 'Alérgico al gluten, rutina baja en impacto'),
    ('María Sánchez', '67756537', 'Tonificar', 'No puede hacer ejercicios de alta intensidad'),
    ('Jorge Pérez', '78452415', 'Ganar masa muscular', 'Dieta alta en proteínas, ejercicios con pesas'),
    ('Ana Gómez', '67756537', 'Mejorar resistencia', 'Vegetariana, rutina con mucho cardio'),
    ('Luis Martínez', '78452415', 'Mantenerse en forma', 'Debe evitar ejercicios de fuerza en rodillas');
""".trimIndent()
        )

        db?.execSQL(
            """
    INSERT INTO alimentacion (titulo, descripcion, noprocesado, procesado) VALUES
    ('Plan Bajo en Carbohidratos', 'Dieta para reducir la ingesta de carbohidratos', 'Verduras, carnes magras, huevos', 'Pan integral, pasta de trigo'),
    ('Plan Alto en Proteínas', 'Dieta para aumentar la masa muscular', 'Huevos, pollo, pescado, lentejas', 'Proteínas en polvo, barras proteicas'),
    ('Plan Vegetariano', 'Dieta sin productos animales', 'Frutas, verduras, granos enteros', 'Quesos, sustitutos de carne procesados'),
    ('Plan Detox', 'Dieta para desintoxicar el cuerpo', 'Frutas, jugos naturales, agua', 'Comidas preprocesadas limitadas'),
    ('Plan Alto en Fibra', 'Dieta para mejorar la digestión', 'Avena, frutas, vegetales frescos', 'Pan de fibra procesada, cereales de caja'),
    ('Plan Hipocalórico', 'Dieta para reducir el consumo calórico', 'Verduras, frutas bajas en azúcar', 'Barras de granola bajas en calorías'),
    ('Plan Energético', 'Dieta para aumentar la energía', 'Frutas, frutos secos, avena', 'Barras de cereales, snacks procesados');
""".trimIndent()
        )

        db?.execSQL(
            """
    INSERT INTO categoria_ejer (nombre, descripcion) VALUES
    ('Cardio', 'Ejercicios enfocados en aumentar la resistencia cardiovascular'),
    ('Fuerza', 'Ejercicios enfocados en el aumento de la fuerza muscular'),
    ('Resistencia', 'Ejercicios para mejorar la resistencia general'),
    ('Flexibilidad', 'Ejercicios que mejoran la flexibilidad'),
    ('Core', 'Ejercicios para fortalecer el abdomen y la espalda baja'),
    ('Movilidad', 'Ejercicios para mejorar el rango de movimiento de las articulaciones'),
    ('Potencia', 'Ejercicios de explosión para desarrollar potencia muscular'),
    ('Calistenia', 'Ejercicios que utilizan el peso corporal como resistencia');
""".trimIndent()
        )

        db?.execSQL(
            """
    INSERT INTO planEjercicio (titulo, motivo, objetivo, video, proceso) VALUES
    ('Entrenamiento Cardio Básico', 'Mejorar la salud cardiovascular', 'Aumentar la resistencia', 'https://youtu.be/Cqalzxz9daY?si=tkFcJibzaA-jBSXe', 'Correr 30 minutos, bicicleta 20 minutos'),
    ('Entrenamiento de Fuerza', 'Aumentar masa muscular', 'Desarrollar fuerza en brazos y piernas', 'https://youtu.be/ApE_7jnFUyo?si=edMrywdAvVkf-U5z', 'Pesas 3 series, sentadillas con barra 4 series'),
    ('Flexibilidad Avanzada', 'Mejorar la flexibilidad corporal', 'Alcanzar movimientos más fluidos', 'https://youtu.be/bgX8GqYsQAg?si=TWBIQbHzwtH7-M_o', 'Estiramientos de piernas y espalda, yoga 15 min'),
    ('Entrenamiento Core', 'Fortalecer la zona abdominal', 'Desarrollar un core fuerte', 'https://youtu.be/5uFpo7KHOrI?si=ekgHHLrfuAW1IYCs', 'Abdominales, planchas, levantamiento de piernas'),
    ('Movilidad de Cadera', 'Mejorar la movilidad en las caderas', 'Aumentar el rango de movimiento', 'https://youtu.be/2PVk2wUY04k?si=LvnFcYFsXqcknzxw', 'Estiramientos de cadera, giros de torso'),
    ('HIIT de Potencia', 'Desarrollar fuerza explosiva', 'Aumentar la potencia y rapidez', 'https://youtu.be/2PVk2wUY04k?si=LvnFcYFsXqcknzxw', 'Saltos pliométricos, sprints de 30 segundos');
""".trimIndent()
        )

        db?.execSQL(
            """
    INSERT INTO rutina (titulo, id_planAlimentacion) VALUES
    ('Rutina de Pérdida de Peso', 1),
    ('Rutina de Tonificación', 2),
    ('Rutina de Ganancia de Masa Muscular', 3),
    ('Rutina de Mejora de Resistencia', 4),
    ('Rutina de Mantenimiento', 5);
""".trimIndent()
        )

        db?.execSQL(
            """
    INSERT INTO plan_categoria (id_categoriaEjer, id_planEjercicio) VALUES
    (1, 1),
    (2, 2),
    (4, 3),
    (5, 4),
    (6, 5),
    (7, 6);
""".trimIndent()
        )

        db?.execSQL(
            """
    INSERT INTO rutina_ejercicio (id_rutina, id_planEjercicio) VALUES
    (1, 1),
    (2, 4),
    (3, 2),
    (4, 1),
    (5, 5);
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