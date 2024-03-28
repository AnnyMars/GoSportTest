package com.example.gosporttest.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gosporttest.R
import com.example.gosporttest.data.models.Meal

@Composable
fun FoodCard(meal: Meal) {

    val context = LocalContext.current

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.size(100.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(context).data(meal.strMealThumb).build(),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .height(150.dp)
            ) {
                Text(text = meal.strMeal)
                Box(modifier = Modifier.size(height = 50.dp, width = 200.dp)) {
                    Text(
                        text = buildString {
                            val ingredients = listOf(
                                meal.strIngredient1, meal.strIngredient2, meal.strIngredient3,
                                meal.strIngredient4, meal.strIngredient5, meal.strIngredient6,
                                meal.strIngredient7, meal.strIngredient8, meal.strIngredient9,
                                meal.strIngredient10, meal.strIngredient11, meal.strIngredient12,
                                meal.strIngredient13, meal.strIngredient14, meal.strIngredient15,
                                meal.strIngredient16, meal.strIngredient17, meal.strIngredient18,
                                meal.strIngredient19, meal.strIngredient20
                            ).filter { it?.isNotBlank() ?: false }
                            append(ingredients.joinToString(", "))
                        },
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Button(onClick = { }, modifier = Modifier.padding(start = 200.dp)) {
                    Text(text = "345")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewFoodCard() {
////    FoodCard()
//}