package es.cibernarium.jetpackcomposeapp.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){
    //Quan la variable sigui true loguejara; False mostrarà per crear usuari
    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            //Definim la condició que determina la logica segons la situació
            if(showLoginForm.value){
                Text(text = "Iniciar sessió")
                UserForm(
                    isCreateAccount = false
                ){
                    email, clau ->
                }
            } else {
                Text(text = "Crea un compte")
                UserForm(
                    isCreateAccount = true
                ){
                    email, clau ->
                }
            }
        }
    }

}

@Composable
fun UserForm(
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = {email, pwd ->}
){
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val clau = rememberSaveable {
        mutableStateOf("")
    }
    //Crearem una nova variable d'estat per saber si la clau es visible o no
    val clauVisible = rememberSaveable {
        mutableStateOf(false)
    }
    //Crearem una columna perque estigui situat en vertical
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        EmailInput(
            emailState = email
        )
        ClauInput(
            clauState = clau,
            labelId = "Clau",
            clauVisible = clauVisible
        )
        SubmitButton(
            textId = if(isCreateAccount) "Crear compte" else "Login"
        )
    }
}

@Composable
fun SubmitButton(
    textId: String
) {
    Button(onClick = {}){
        Text(text = textId,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Composable
fun ClauInput(
    clauState: MutableState<String>,
    labelId: String,
    clauVisible: MutableState<Boolean>
) {
    //Condicional per ocultar o mostrar la clau
    val visualTransformation = if(clauVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    OutlinedTextField(
        value = clauState.value,
        onValueChange = {clauState.value = it},
        label = { Text(text = labelId)},
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        //Icona per mostrar o ocultar la clau
        trailingIcon = {
            //Aquesta icona només tindrà que apareixer quan el camp tingui algún caràcter
            if(clauState.value.isNotBlank()){
                PasswordVisibleIcon(clauVisible)
            } else null
        }
        )
}

@Composable
fun PasswordVisibleIcon(
    clauVisible: MutableState<Boolean>
) {
    val image =
        if(clauVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility
    IconButton(onClick = {
        clauVisible.value = !clauVisible.value
    }) {
        Icon(
            imageVector = image,
            contentDescription = "")
    }
}

//Creem la funció per la entrada del email
@Composable
fun EmailInput(
    emailState: MutableState<String>,
    labelId: String = "Email"
) {
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email  //Definim entrada de dades per un email
    )
}

@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true, //Afegim aquest atribut per definir que només es 1 linia
    keyboardType: KeyboardType
) {
    //Afegim aquest metode per crear el camp de text amb els atributs rebuts
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it},
        label = { Text(text = labelId)},
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}
