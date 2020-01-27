import React from 'react';
import axios from "axios";

import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import './UserAccountsTable.css';
import * as config from "../../config/config";

class UserAccountsTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userAccounts: []
        }
    }

    sortTableAscending = (userAccounts, criteria) => {
        let sortedArray = userAccounts;
        sortedArray.sort(function (a, b) {
            return a[criteria].localeCompare(b[criteria])
        });
        this.setState({
            userAccounts: sortedArray,
        })
    };

    sortTableDescending = (userAccounts, criteria) => {
        let sortedArray = userAccounts;
        sortedArray.sort(function (a, b) {
            return b[criteria].localeCompare(a[criteria])
        });
        this.setState({
            userAccounts: sortedArray,
        })
    };

    sortTableAscendingByDate = (userAccounts) => {
        let sortedArray = userAccounts;
        sortedArray.sort(function (a, b) {
            return new Date(a.dateOfBirth) - new Date(b.dateOfBirth)
        });
        this.setState({
            userAccounts: sortedArray,
        })
    };

    sortTableDescendingByDate = (userAccounts) => {
        let sortedArray = userAccounts;
        sortedArray.sort(function (a, b) {
            return new Date(b.dateOfBirth) - new Date(a.dateOfBirth)
        });
        this.setState({
            userAccounts: sortedArray,
        })
    };

    removeAccount = (i, userAccounts, accountId) => {
        let newUserAccounts = userAccounts.splice(i, 1);
        this.setState({
            userAccounts: newUserAccounts
        });

        axios.delete(config.userAccountManagementBackendUrl + `\\${accountId}`)
            .then(res => {});
    };

    render() {
        const userAccounts = this.props.users;
        return (
            <Table id="userAccountsTable" striped bordered hover width="100%">
                <thead>
                <tr>
                    <th className="th-sm">
                        First Name
                        <Button onClick={() => this.sortTableAscending(userAccounts, "firstName")}
                                variant="outline-info" size="sm">&#8593;</Button>{' '}
                        <Button onClick={() => this.sortTableDescending(userAccounts, "firstName")}
                                variant="outline-info" size="sm">&#8595;</Button>{' '}
                    </th>
                    <th className="th-sm">Last Name
                        <Button onClick={() => this.sortTableAscending(userAccounts, "lastName")}
                                variant="outline-info" size="sm">&#8593;</Button>{' '}
                        <Button onClick={() => this.sortTableDescending(userAccounts, "lastName")}
                                variant="outline-info" size="sm">&#8595;</Button>{' '}

                    </th>
                    <th className="th-sm">Email
                        <Button onClick={() => this.sortTableAscending(userAccounts, "emailAddress")}
                                variant="outline-info" size="sm">&#8593;</Button>{' '}
                        <Button onClick={() => this.sortTableDescending(userAccounts, "emailAddress")}
                                variant="outline-info" size="sm">&#8595;</Button>{' '}
                    </th>
                    <th className="th-sm">Date of Birth
                        <Button onClick={() => this.sortTableAscendingByDate(userAccounts)}
                                variant="outline-info" size="sm">&#8593;</Button>{' '}
                        <Button onClick={() => this.sortTableDescendingByDate(userAccounts)}
                                variant="outline-info" size="sm">&#8593;</Button>{' '}
                    </th>
                </tr>
                </thead>

                <tbody>
                {userAccounts.map((account, i) => (
                    <tr key={i}>
                        <td>{account.firstName}</td>
                        <td>{account.lastName}</td>
                        <td>{account.emailAddress}</td>
                        <td>{account.dateOfBirth}</td>
                        <td>
                            <Button
                                    onClick={i => this.removeAccount(i, userAccounts, account.id)}
                                    variant="outline-danger" size="sm">Remove</Button>{' '}
                        </td>
                    </tr>
                ))}
                </tbody>

            </Table>
        )
    }
};

export default UserAccountsTable;