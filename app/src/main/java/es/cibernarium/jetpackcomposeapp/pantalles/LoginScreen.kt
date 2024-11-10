package es.cibernarium.jetpackcomposeapp.pantalles

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.cibernarium.jetpackcomposeapp.miSQLiteHelper

@Composable
fun LoginScreen(navController: NavController,usersDBHelper: miSQLiteHelper){
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
        ) {
            //Definim la condició que determina la logica segons la situació
            if (showLoginForm.value) {
                Text(text = "Iniciar sessió")
                UserForm(
                    isCreateAccount = false
                ) { email, clau ->
                    //Afegim un log per saber si és submiteja el login
                    Log.d("Refugios Libres", "Loguejant amb $email i $clau")
                }
            } else {
                Text(text = "Crea un compte")
                UserForm(
                    isCreateAccount = true
                ) { email, clau ->
                    usersDBHelper.afegirDades(email.toString(),clau.toString())
                    Log.d("Refugios Libres", "Guardant dades $email i $clau")
                }
            }

            //Crearem un espaiador
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Realitzem els textes per cada ocasió
                val text1 =
                    if (showLoginForm.value) "No tens compte?"
                    else "Ja tens compte?"
                val text2 =
                    if (showLoginForm.value) "Registra't"
                    else "Inicia sessió"
                //Crearem els dos components de texte
                Text(text = text1)
                Text(text = text2,
                    //Afegim un modificador per fer-ho clickable i modificar el valor
                    //showLoginForm per mostrar/ocultar el registre o login
                    modifier = Modifier
                        .clickable { showLoginForm.value = !showLoginForm.value }
                        .padding(start = 5.dp),
                    color = Color.Blue
                )
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
    //Crearem una variable per saber si tots els camps són vàlids
    val valid = remember(email.value,clau.value){
        //Obtenim el valor, eliminem espais en blanc i validem que no està buit
        email.value.trim().isNotEmpty() &&
                clau.value.trim().isNotEmpty()
    }
    //Obtenim el estat de visibilitat del teclat el fer submit
    val keyboardController = LocalSoftwareKeyboardController.current
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
            textId = if(isCreateAccount) "Crear compte" else "Login",
            //Rebem el valor de si els camps estàn ok de la variable valid
            inputValid = valid
        ){
            //Invoquem la funció onDone() per a quan estigui tot gestioni el formulari
            onDone(email.value.trim(),clau.value.trim())
            //Amaguem el teclat el fer submit
            keyboardController?.hide()
        }
    }
}

@Composable
fun SubmitButton(
    textId: String,
    //Rebem el valor de inputValid
    inputValid: Boolean,
    //Desenvolupem la acció onClick
    onClic: ()->Unit
) {
    Button(onClick = onClic, //També aqui enllaçem amb el onClic
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValid //Habilitem el botò segons si inputValid és true
    ){
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
