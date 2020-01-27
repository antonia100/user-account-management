import React from 'react';
import axios from 'axios';

import * as config from "../config/config";
import UserAccountTable from '../components/UserAccountsTable/UserAccountsTable';

class Main extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [],
            showModal: false,
            startDate: new Date()
        };
    }

    componentDidMount() {
        axios.get(config.userAccountManagementBackendUrl)
            .then(res => {
                const cleanedUpAccounts = this.cleanUpDates(res.data);
                this.setState({
                    users: cleanedUpAccounts
                });

            }).catch((err) => {
            console.log(err)
        });
    }

    cleanUpDates(accounts) {
        for(let a of accounts){
            a.dateOfBirth =  a.dateOfBirth.split("T")[0];
        }
        return accounts;
    }

    render() {
        const users = this.state.users;
        return (
            <div>
                <UserAccountTable users={users}></UserAccountTable>
            </div>
        )
    }

}

export default Main;