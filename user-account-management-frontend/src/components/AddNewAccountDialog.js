import React, {useState} from 'react';
import axios from 'axios';

import Modal from 'react-bootstrap/Modal'
import Button from 'react-bootstrap/Button';
import Form from "react-bootstrap/Form";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import * as config from '../config/config';

const AddNewAccountDialog = (props) => {

    let [values, setValues] = useState({firstName: '', lastName: '', emailAddress: '', dateOfBirth: ''});

    const handleInputChange = e => {
        setValues({...values, [e.target.name]: e.target.value})
    };

    const handleSubmit = event => {
        event.preventDefault();
        createNewUserAccount({
            firstName: values.firstName,
            lastName: values.lastName,
            emailAddress: values.emailAddress,
            dateOfBirth: values.dateOfBirth
        });
    };

    const createNewUserAccount = (newUserAccount) => {
        axios.post(config.userAccountManagementBackendUrl, newUserAccount)
            .then(res => {
                window.location.reload()
            }).catch(err => {

        })
    };

    return (
        <Modal
            {...props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered>
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Add New User Account
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>

                <Form onSubmit={handleSubmit}>
                    <Row>
                        <Col>
                            <Form.Label>First Name</Form.Label>
                            <Form.Control type="text" name="firstName" required onChange={handleInputChange}/>
                        </Col>
                        <Col>
                            <Form.Label>Last Name</Form.Label>
                            <Form.Control type="text" name="lastName" required onChange={handleInputChange}/>
                        </Col>
                    </Row>

                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" name="emailAddress" required onChange={handleInputChange}/>

                    <Form.Label>Date of Birth</Form.Label>
                    <Form.Control type="date" name="dateOfBirth" max='2020-01-01' required onChange={handleInputChange}/>
                    <br/>
                    <Button variant="primary" size="lg" block type="submit">
                        Submit
                    </Button>
                </Form>

            </Modal.Body>
            <Modal.Footer>
                <Button variant="outline-danger" onClick={props.onHide}>Close</Button>
            </Modal.Footer>
        </Modal>
    );
};

export default AddNewAccountDialog;