import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun FormScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Define the submission function as a lambda
    val submit: () -> Unit = {
        // Simulate form submission
        println("Submitting form with username: $username, password: $password")
    }

    suspend fun test(){

    }

    // Remember the updated state of the submit function
    val currentSubmitFunction by rememberUpdatedState(submit)

    Surface(color = MaterialTheme.colorScheme.primary) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Username input field
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Password input field
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Submit button
            Button(onClick = {
                // Call the current version of the submit function
                currentSubmitFunction()
                submit()
            }) {
                Text("Submit")
            }
        }
    }
}
