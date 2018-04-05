import { BaseEntity } from './../../shared';

export class EventOptJob implements BaseEntity {
    constructor(
        public id?: number,
        public type?: string,
        public created?: any,
        public campaignId?: number,
        public publisherId?: number,
    ) {
    }
}
