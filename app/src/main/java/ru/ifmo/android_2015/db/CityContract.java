package ru.ifmo.android_2015.db;

import android.provider.BaseColumns;

/**
 * Определения реляционной модели данных городов.
 */
public final class CityContract {

    /**
     * Колонки таблицы гордов.
     *
     * Из базового интерфейса BaseColumn используется колонка _ID -- ID строки SQLite таблицы,
     * в котором хранится ID города.
     */
    public interface CityColumns extends BaseColumns {

        /**
         * Название города.
         *
         * SQLite type: TEXT
         */
        String NAME = "name";

        /**
         * Двухбуквенный код страны.
         *
         * SQLite type: TEXT
         */
        String COUNTRY = "country";

        /**
         * Широта в градусах.
         *
         * SQLite type: REAL
         */
        String LATITUDE = "latitude";

        /**
         * Долгота в градусах.
         *
         * SQLite type: REAL
         */
        String LONGITUDE = "longitude";
    }

    /**
     * Определение таблицы городов.
     *
     * Примечеание: этот класс определен как "implements CityColumns" для удобства, чтобы
     *              константы интерфейса оказались в области видимости этого класса.
     */
    static final class Cities implements CityColumns {

        /**
         * Название таблицы городов.
         */
        static final String TABLE = "cities";

        /**
         * Название индекса таблицы городов по названию города.
         */
        static final String IDX_NAME = "idx_cities_name";

        static final String CREATE_TABLE = "CREATE TABLE " + TABLE
                + " ("
                + _ID + " INTEGER PRIMARY KEY, "
                + NAME + " TEXT NON NULL, "
                + COUNTRY + " TEXT NON NULL, "
                + LATITUDE + " REAL NON NULL, "
                + LONGITUDE + " REAL NON NULL"
                + " )";

        static final String CREATE_IDX_NAME = "CREATE INDEX " + IDX_NAME
                + " ON " + TABLE + " (" + NAME + ")";

    }

    private CityContract() {}
}
