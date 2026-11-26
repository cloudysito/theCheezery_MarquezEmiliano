package marquez.emiliano.thecheezery.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import marquez.emiliano.thecheezery.model.data.database.dao.ComboDao
import marquez.emiliano.thecheezery.model.data.database.dao.ProductComboDao
import marquez.emiliano.thecheezery.model.data.database.dao.ProductDao
import marquez.emiliano.thecheezery.model.data.database.entity.ProductEntity
import marquez.emiliano.thecheezery.model.data.database.entity.ComboEntity
import marquez.emiliano.thecheezery.model.data.database.entity.ProductComboEntity

@Database(
    entities = [
        ProductEntity::class,
        ComboEntity::class,
        ProductComboEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun comboDao(): ComboDao
    abstract fun productsComboDao(): ProductComboDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cheezery.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

