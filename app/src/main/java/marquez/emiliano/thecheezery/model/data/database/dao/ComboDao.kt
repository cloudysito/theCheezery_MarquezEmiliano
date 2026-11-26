package marquez.emiliano.thecheezery.model.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import marquez.emiliano.thecheezery.model.data.database.entity.ComboEntity
import marquez.emiliano.thecheezery.model.data.database.relation.ComboWithProducts

@Dao
interface ComboDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCombo(combo: ComboEntity): Long

    @Transaction
    @Query("SELECT * FROM Combos")
    fun getCombosWithProducts(): Flow<List<ComboWithProducts>>
}
