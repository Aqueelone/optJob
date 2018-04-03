import { BaseEntity } from './../../shared';

export const enum EventType {
    'SOURCE_EVENT',
    'MEASURED_EVENT'
}

export class EventOptJob implements BaseEntity {
    constructor(
        public id?: number,
        public type?: string,
        public eventType?: EventType,
        public campaignId?: number,
        public publisherId?: number,
    ) {
    }
}
