import React from 'react';
import './App.css';
import Main from './container/Main'
import AddNewAccountDialog from "./components/AddNewAccountDialog";
import Button from 'react-bootstrap/Button';

function App() {
    const [modalShow, setModalShow] = React.useState(false);

    return (
        <div className="App">
            <h2>User Account Management</h2>
            <Button variant="primary" size="lg" block onClick={() => setModalShow(true)}>
                Add New User Account
            </Button>
            <AddNewAccountDialog show={modalShow} onHide={() => setModalShow(false)}/>
            <Main></Main>
        </div>
    );
}

export default App;
