package marquez.emiliano.thecheezery.model.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import marquez.emiliano.thecheezery.model.data.database.entity.ProductComboEntity

@Dao
interface ProductComboDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductCombo(productCombo: ProductComboEntity): Long
}
